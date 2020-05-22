package io.boodskap.iot.model.jpa;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;

import io.boodskap.iot.DataType;
import io.boodskap.iot.SizeConstants;
import io.boodskap.iot.StorageException;
import io.boodskap.iot.ThreadContext;
import io.boodskap.iot.model.IDynamicField;

@MappedSuperclass
public abstract class DynamicField implements IDynamicField {
	
	private static final long serialVersionUID = 8521375450218976930L;

	@Column(name="tvalue", length=SizeConstants.MESSAGE_FIELD_VALUE_SIZE)
	private String value;
	
	@Column(name="dvalue")
	private Double nvalue;
	
	@Enumerated(EnumType.STRING)
	@Column(name="fdatatype")
	private DataType dataType;
	
	public DynamicField() {
	}

	@Override
	public DataType getDataType() {
		return dataType;
	}

	@Override
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getNvalue() {
		return nvalue;
	}

	public void setNvalue(Double nvalue) {
		this.nvalue = nvalue;
	}

	@Override
	public void setField(String name, Serializable value) throws StorageException {
		
		try {
			
			setName(name);
			
			if(null == value) {
				setDataType(DataType.STRING);
				return;
			}
			
			
			String converted = value.toString();
			dataType = DataType.STRING;
			boolean primitive = value.getClass().isPrimitive();
			
			if(value instanceof Byte) {
				dataType = primitive ? DataType._byte : DataType.BYTE;
				nvalue = ((Byte)value).doubleValue();
			}else if(value instanceof Boolean) {
				dataType = primitive ? DataType._boolean : DataType.BOOLEAN;
			}else if(value instanceof Short) {
				dataType = primitive ? DataType._short : DataType.SHORT;
				nvalue = ((Short)value).doubleValue();
			}else if(value instanceof Integer) {
				dataType = primitive ? DataType._int : DataType.INT;			
				nvalue = ((Integer)value).doubleValue();
			}else if(value instanceof Long) {
				dataType = primitive ? DataType._long : DataType.LONG;
				nvalue = ((Long)value).doubleValue();
			}else if(value instanceof Float) {
				dataType = primitive ? DataType._float : DataType.FLOAT;
				nvalue = ((Float)value).doubleValue();
			}else if(value instanceof Double) {
				dataType = primitive ? DataType._double : DataType.DOUBLE;
				nvalue = (Double)value;
			}else if(value instanceof Character) {
				dataType = primitive ? DataType._char : DataType.CHAR;
			}else if(value instanceof String) {
				dataType = DataType.STRING;
			}else if(value instanceof UUID) {
				dataType = DataType.UUID;
			}else if(value instanceof Byte[]) {
				dataType = DataType.BLOB;
				Byte[] barr = (Byte[]) value;
				converted = Base64.encodeBase64String(ArrayUtils.toPrimitive(barr));
			}else if(value instanceof byte[]) {
				dataType = DataType._blob;
				byte[] barr = (byte[]) value;
				converted = Base64.encodeBase64String(barr);
			}else if(value instanceof Map<?,?>){
				dataType = DataType.JSON;
				@SuppressWarnings("unchecked")
				Map<String,Object> json = (Map<String, Object>) value;
				converted = ThreadContext.mapToJson(json);
			}
			
			this.value = converted;
			
		}catch(Exception ex) {
			throw new StorageException(ex);
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataType == null) ? 0 : dataType.hashCode());
		result = prime * result + ((nvalue == null) ? 0 : nvalue.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DynamicField other = (DynamicField) obj;
		if (dataType != other.dataType)
			return false;
		if (nvalue == null) {
			if (other.nvalue != null)
				return false;
		} else if (!nvalue.equals(other.nvalue))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}