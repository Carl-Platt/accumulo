/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.apache.accumulo.core.data.thrift;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

@SuppressWarnings("serial")
public class TKeyValue implements TBase<TKeyValue,TKeyValue._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("TKeyValue");
  
  private static final TField KEY_FIELD_DESC = new TField("key", TType.STRUCT, (short) 1);
  private static final TField VALUE_FIELD_DESC = new TField("value", TType.STRING, (short) 2);
  
  public TKey key;
  public byte[] value;
  
  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    KEY((short) 1, "key"), VALUE((short) 2, "value");
    
    private static final java.util.Map<String,_Fields> byName = new java.util.HashMap<String,_Fields>();
    
    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }
    
    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch (fieldId) {
        case 1: // KEY
          return KEY;
        case 2: // VALUE
          return VALUE;
        default:
          return null;
      }
    }
    
    /**
     * Find the _Fields constant that matches fieldId, throwing an exception if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null)
        throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }
    
    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }
    
    private final short _thriftId;
    private final String _fieldName;
    
    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }
    
    public short getThriftFieldId() {
      return _thriftId;
    }
    
    public String getFieldName() {
      return _fieldName;
    }
  }
  
  // isset id assignments
  
  public static final java.util.Map<_Fields,FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields,FieldMetaData> tmpMap = new java.util.EnumMap<_Fields,FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.KEY, new FieldMetaData("key", TFieldRequirementType.DEFAULT, new StructMetaData(TType.STRUCT, TKey.class)));
    tmpMap.put(_Fields.VALUE, new FieldMetaData("value", TFieldRequirementType.DEFAULT, new FieldValueMetaData(TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(TKeyValue.class, metaDataMap);
  }
  
  public TKeyValue() {}
  
  public TKeyValue(TKey key, byte[] value) {
    this();
    this.key = key;
    this.value = value;
  }
  
  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TKeyValue(TKeyValue other) {
    if (other.isSetKey()) {
      this.key = new TKey(other.key);
    }
    if (other.isSetValue()) {
      this.value = new byte[other.value.length];
      System.arraycopy(other.value, 0, value, 0, other.value.length);
    }
  }
  
  public TKeyValue deepCopy() {
    return new TKeyValue(this);
  }
  
  @Deprecated
  public TKeyValue clone() {
    return new TKeyValue(this);
  }
  
  public TKey getKey() {
    return this.key;
  }
  
  public TKeyValue setKey(TKey key) {
    this.key = key;
    return this;
  }
  
  public void unsetKey() {
    this.key = null;
  }
  
  /** Returns true if field key is set (has been asigned a value) and false otherwise */
  public boolean isSetKey() {
    return this.key != null;
  }
  
  public void setKeyIsSet(boolean value) {
    if (!value) {
      this.key = null;
    }
  }
  
  public byte[] getValue() {
    return this.value;
  }
  
  public TKeyValue setValue(byte[] value) {
    this.value = value;
    return this;
  }
  
  public void unsetValue() {
    this.value = null;
  }
  
  /** Returns true if field value is set (has been asigned a value) and false otherwise */
  public boolean isSetValue() {
    return this.value != null;
  }
  
  public void setValueIsSet(boolean value) {
    if (!value) {
      this.value = null;
    }
  }
  
  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
      case KEY:
        if (value == null) {
          unsetKey();
        } else {
          setKey((TKey) value);
        }
        break;
      
      case VALUE:
        if (value == null) {
          unsetValue();
        } else {
          setValue((byte[]) value);
        }
        break;
    
    }
  }
  
  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }
  
  public Object getFieldValue(_Fields field) {
    switch (field) {
      case KEY:
        return getKey();
        
      case VALUE:
        return getValue();
        
    }
    throw new IllegalStateException();
  }
  
  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }
  
  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
      case KEY:
        return isSetKey();
      case VALUE:
        return isSetValue();
    }
    throw new IllegalStateException();
  }
  
  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }
  
  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TKeyValue)
      return this.equals((TKeyValue) that);
    return false;
  }
  
  public boolean equals(TKeyValue that) {
    if (that == null)
      return false;
    
    boolean this_present_key = true && this.isSetKey();
    boolean that_present_key = true && that.isSetKey();
    if (this_present_key || that_present_key) {
      if (!(this_present_key && that_present_key))
        return false;
      if (!this.key.equals(that.key))
        return false;
    }
    
    boolean this_present_value = true && this.isSetValue();
    boolean that_present_value = true && that.isSetValue();
    if (this_present_value || that_present_value) {
      if (!(this_present_value && that_present_value))
        return false;
      if (!java.util.Arrays.equals(this.value, that.value))
        return false;
    }
    
    return true;
  }
  
  @Override
  public int hashCode() {
    return 0;
  }
  
  public int compareTo(TKeyValue other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }
    
    int lastComparison = 0;
    TKeyValue typedOther = (TKeyValue) other;
    
    lastComparison = Boolean.valueOf(isSetKey()).compareTo(typedOther.isSetKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKey()) {
      lastComparison = TBaseHelper.compareTo(this.key, typedOther.key);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetValue()).compareTo(typedOther.isSetValue());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetValue()) {
      lastComparison = TBaseHelper.compareTo(this.value, typedOther.value);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }
  
  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true) {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) {
        break;
      }
      switch (field.id) {
        case 1: // KEY
          if (field.type == TType.STRUCT) {
            this.key = new TKey();
            this.key.read(iprot);
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // VALUE
          if (field.type == TType.STRING) {
            this.value = iprot.readBinary();
          } else {
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    
    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }
  
  public void write(TProtocol oprot) throws TException {
    validate();
    
    oprot.writeStructBegin(STRUCT_DESC);
    if (this.key != null) {
      oprot.writeFieldBegin(KEY_FIELD_DESC);
      this.key.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.value != null) {
      oprot.writeFieldBegin(VALUE_FIELD_DESC);
      oprot.writeBinary(this.value);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TKeyValue(");
    sb.append("key:");
    if (this.key == null) {
      sb.append("null");
    } else {
      sb.append(this.key);
    }
    sb.append(", ");
    sb.append("value:");
    if (this.value == null) {
      sb.append("null");
    } else {
      int __value_size = Math.min(this.value.length, 128);
      for (int i = 0; i < __value_size; i++) {
        if (i != 0)
          sb.append(" ");
        sb.append(Integer.toHexString(this.value[i]).length() > 1 ? Integer.toHexString(this.value[i])
            .substring(Integer.toHexString(this.value[i]).length() - 2).toUpperCase() : "0" + Integer.toHexString(this.value[i]).toUpperCase());
      }
      if (this.value.length > 128)
        sb.append(" ...");
    }
    sb.append(")");
    return sb.toString();
  }
  
  public void validate() throws TException {
    // check for required fields
  }
  
}