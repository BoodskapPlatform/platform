package io.boodskap.iot.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import io.boodskap.iot.DataType;
import io.boodskap.iot.model.IMessageField;

@Embeddable
public class MessageField extends AbstractField implements IMessageField {

	private static final long serialVersionUID = -6373844951592507837L;

	@Column(name="indexed")
	private boolean indexed;

	@Column(name="fullindexed")
	private boolean fulltextIndexed;
	
	public MessageField(){
	}

	public MessageField(String name, DataType dataType) {
		setName(name);
		setDataType(dataType);
	}

	@Override
	public final boolean isIndexed() {
		return indexed;
	}

	@Override
	public final void setIndexed(boolean indexed) {
		this.indexed = indexed;
	}

	@Override
	public final boolean isFulltextIndexed() {
		return fulltextIndexed;
	}

	@Override
	public final void setFulltextIndexed(boolean fulltextIndexed) {
		this.fulltextIndexed = fulltextIndexed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (fulltextIndexed ? 1231 : 1237);
		result = prime * result + (indexed ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageField other = (MessageField) obj;
		if (fulltextIndexed != other.fulltextIndexed)
			return false;
		if (indexed != other.indexed)
			return false;
		return true;
	}

}
