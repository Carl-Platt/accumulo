/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.accumulo.test.functional;

import static org.junit.Assert.assertEquals;

import java.security.MessageDigest;
import java.util.Map.Entry;

import org.apache.accumulo.core.client.BatchWriter;
import org.apache.accumulo.core.client.BatchWriterConfig;
import org.apache.accumulo.core.client.Connector;
import org.apache.accumulo.core.client.Scanner;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Mutation;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.security.Authorizations;
import org.apache.accumulo.examples.simple.mapreduce.RowHash;
import org.apache.hadoop.io.Text;
import org.codehaus.plexus.util.Base64;
import org.junit.Test;

public class MapReduceIT extends ConfigurableMacIT {

  static final String tablename = "mapredf";
  static final String input_cf = "cf-HASHTYPE";
  static final String input_cq = "cq-NOTHASHED";
  static final String input_cfcq = input_cf + ":" + input_cq;
  static final String output_cq = "cq-MD4BASE64";
  static final String output_cfcq = input_cf + ":" + output_cq;

  @Test(timeout = 60 * 1000)
  public void test() throws Exception {
    Connector c = getConnector();
    c.tableOperations().create(tablename);
    BatchWriter bw = c.createBatchWriter(tablename, new BatchWriterConfig());
    for (int i = 0; i < 10; i++) {
      Mutation m = new Mutation("" + i);
      m.put(input_cf, input_cq, "row" + i);
      bw.addMutation(m);
    }
    bw.close();

    Process hash = exec(RowHash.class, "-i", c.getInstance().getInstanceName(), "-z", c.getInstance().getZooKeepers(), "-u", "root", "-p", ROOT_PASSWORD, "-t",
        tablename, "--column", input_cfcq);
    assertEquals(0, hash.waitFor());

    Scanner s = c.createScanner(tablename, Authorizations.EMPTY);
    s.fetchColumn(new Text(input_cf), new Text(output_cq));
    int i = 0;
    for (Entry<Key,Value> entry : s) {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] check = Base64.encodeBase64(md.digest(("row" + i).getBytes()));
      assertEquals(entry.getValue().toString(), new String(check));
      i++;
    }

  }

}
