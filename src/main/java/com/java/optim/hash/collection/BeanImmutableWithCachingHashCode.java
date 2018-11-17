package com.java.optim.hash.collection;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BeanImmutableWithCachingHashCode extends RootBean{

	private int cachingHashCode;

	public BeanImmutableWithCachingHashCode(int price, boolean available, String name, Date creation,
			List<String> owner) {
		super();
		this.price = price;
		this.available = available;
		this.name = name;
		this.creation = creation;
		this.owner = owner;
		cachingHashCode=initialisationHashCode();
	}

	public boolean isAvailable() {
		return available;
	}

	public int getPrice() {
		return price;
	}


	public String getName() {
		return name;
	}


	public Date getCreation() {
		return new Date(creation.getTime());
	}


	public List<String> getOwner() {
		return Collections.unmodifiableList(owner);
	}


	private int initialisationHashCode() {
		int result = 1;
		final int prime = 31;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public int hashCode() {
		return cachingHashCode;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BeanImmutableWithCachingHashCode that = (BeanImmutableWithCachingHashCode) o;
		return price == that.price &&
				available == that.available &&
				cachingHashCode == that.cachingHashCode &&
				Objects.equals(name, that.name) &&
				Objects.equals(creation, that.creation) &&
				Objects.equals(owner, that.owner);
	}
}
