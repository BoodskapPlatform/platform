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
public abstract class AbstractDynamicField extends AbstractStorable implements IDynamicField {
	
	private static final long serialVersionUID = 8521375450218976930L;

	@Column(name="tvalue", length=SizeConstants.MESSAGE_FIELD_VALUE_SIZE)
	private String value;
	
	@Column(name="dvalue")
	private Double nvalue;
	
	@Enumerated(EnumType.STRING)
	@Column(name="fdatatype")
	private DataType dataType;
	
	public AbstractDynamicField() {
	}

	@Override
	public final DataType getDataType() {
		return dataType;
	}

	@Override
	public final void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public final String getValue() {
		return value;
	}

	public final void setValue(String value) {
		this.value = value;
	}

	public final Double getNvalue() {
		return nvalue;
	}

	public final void setNvalue(Double nvalue) {
		this.nvalue = nvalue;
	}

	@Override
	public final void setField(String name, Serializable value) throws StorageException {
		
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

}
