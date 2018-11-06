package com.java.optim.hash.collection;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.java.optim.hashcode.collection.BeanWithHash;
import com.java.optim.hashcode.collection.BeanWithHashImmutable;
import com.java.optim.hashcode.collection.BeanWithPersonalizedHashImmutable;
import com.java.optim.hashcode.collection.BeanWithSameHashValue;
import com.java.optim.hashcode.collection.BeanWithoutHash;

public class HashCodeTest {

	private int iteration=50000;
	
	@Test
	@DisplayName("Should not find bean if hashCode method is not defined")
	public void shouldBeSlowWithBeanWithoutHash() {
		System.out.println("shouldBeSlowWithBeanWithoutHash");
		Map<BeanWithoutHash,String> hashTable = new Hashtable<BeanWithoutHash,String>();
		BeanWithoutHash bean = null;
		long debut = System.nanoTime();
		Date now = new Date();
		List<String> owner =Arrays.asList("Martin","Paul");
		for (int i = 0; i < iteration; i++) {
			bean = new BeanWithoutHash(i,true,"aName"+i,now,owner);
			hashTable.put(bean,bean.toString());
		}
		long fin = System.nanoTime();
		System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");
		debut = System.nanoTime();
		bean = new BeanWithoutHash(3568,true,"aName3568",now,owner);
		boolean isPresent=hashTable.containsKey(bean);

		fin = System.nanoTime();
		System.out.println("HashTable temps de recherche = "+ Math.abs(fin - debut) + " nano secondes");
		System.out.println(isPresent ? "I find the result":"I do not find the result");
		assertFalse( isPresent, () -> "Does not manage to retreave key without hashcode implementation");
	}

	@Test
	@DisplayName("Should find bean if hashCode method is defined")
	public void shouldFindValueWithBeanWithHash() {
		System.out.println("shouldFindValueWithBeanWithHash");
		Map<BeanWithHash,String> hashTable = new Hashtable<BeanWithHash,String>();
		BeanWithHash bean = null;
		long debut = System.nanoTime();
		Date now = new Date();
		List<String> owner =Arrays.asList("Martin","Paul");
		for (int i = 0; i < iteration; i++) {
			bean = new BeanWithHash(i,true,"aName"+i,now,owner);
			hashTable.put(bean,bean.toString());
		}
		long fin = System.nanoTime();
		System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");
		debut = System.nanoTime();
		bean = new BeanWithHash(3504,true,"aName3504",now,owner);
		String res = null;
		if (hashTable.containsKey(bean)) {
			res=hashTable.get(bean);
		}
		fin = System.nanoTime();
		System.out.println("HashTable temps de recherche = "+ Math.abs(fin - debut) + " nanoSecondes");

		System.out.println(Objects.nonNull(res) ? "I find the result":"I do not find the result");

		assertNotNull(res,"Manage to match the key and value");
	}
	
	@Test
	@DisplayName("Should find bean when hashCode method is defined but slow because the hashcode method return always the same value and the repartition is bad")
	public void shouldBeSlowWithBeanWithBadHash() {
		System.out.println("shouldBeSlowWithBeanWithBadHash");
		Map<BeanWithSameHashValue,String> hashTable = new Hashtable<BeanWithSameHashValue,String>();
		BeanWithSameHashValue bean = null;
		long debut = System.nanoTime();
		Date now = new Date();
		List<String> owner =Arrays.asList("Martin","Paul");
		for (int i = 0; i < iteration; i++) {
			bean = new BeanWithSameHashValue(i,true,"aName"+i,now,owner);
			hashTable.put(bean,bean.toString());
		}
		long fin = System.nanoTime();
		System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");
		debut = System.nanoTime();
		bean = new BeanWithSameHashValue(3504,true,"aName3504",now,owner);
		String res = null;
		if (hashTable.containsKey(bean)) {
			res=hashTable.get(bean);
		}
		fin = System.nanoTime();
		System.out.println("HashTable temps de recherche = "+ Math.abs(fin - debut) +"nano secondes");

		System.out.println(Objects.nonNull(res) ? "I find the result":"I do not find the result");

		assertNotNull(res,"Manage to match the key and value");
	}
	
	
	@Test
	public void shouldBeSlowThanClassicHashWithBeanWithHashImmutable() {
		System.out.println("shouldBeSlowThanClassicHashWithBeanWithHashImmutable");
		Map<BeanWithHashImmutable,String> hashTable = new Hashtable<BeanWithHashImmutable,String>();
		BeanWithHashImmutable bean = null;
		long debut = System.nanoTime();
		Date now = new Date();
		List<String> owner =Arrays.asList("Martin","Paul");
		for (int i = 0; i < iteration; i++) {
			bean = new BeanWithHashImmutable(i,true,"aName"+i,now,owner);
			hashTable.put(bean,bean.toString());
		}
		long fin = System.nanoTime();
		System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");
		debut = System.nanoTime();
		bean = new BeanWithHashImmutable(3504,true,"aName3504",now,owner);
		String res = null;
		if (hashTable.containsKey(bean)) {
			res=hashTable.get(bean);
		}
		fin = System.nanoTime();
		System.out.println("HashTable temps de recherche = "+ Math.abs(fin - debut) + " nano secondes");

		System.out.println(Objects.nonNull(res) ? "I find the result":"I do not find the result");

		assertNotNull(res,"Manage to match the key and value");
	}
	
	@Test
	public void shouldBeSlowToSearchWhenKeyValueIsChanged() {
		System.out.println("shouldBeSlowToSearchWhenKeyValueIsChanged");
		Map<BeanWithHash,String> hashTable = new Hashtable<BeanWithHash,String>();
		BeanWithHash bean = null;
		long debut = System.nanoTime();
		Date now = new Date();
		List<String> owner =Arrays.asList("Martin","Paul");
		BeanWithHash mutableKey = new BeanWithHash(225546,true,"plouf",now,owner);
		for (int i = 0; i < iteration; i++) {
			if (i==2365) {
				bean=mutableKey;
			}else {
			bean = new BeanWithHash(i,true,"aName"+i,now,owner);
			}
			hashTable.put(bean,bean.toString());
		}
		long fin = System.nanoTime();
		System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");
		debut = System.nanoTime();
		bean = new BeanWithHash(3504,true,"aName3504",now,owner);
		String res = null;
		if (hashTable.containsKey(bean)) {
			res=hashTable.get(bean);
		}
		fin = System.nanoTime();
		System.out.println("HashTable temps de recherche = "+ Math.abs(fin - debut) + " nano secondes");

		mutableKey.setCreation(new Date());
		mutableKey.setOwner(new ArrayList<>());
		mutableKey.setPrice(-542671);
		mutableKey.setName("MUTATION");
		debut = System.nanoTime();
		if (hashTable.containsKey(mutableKey)) {
			res=hashTable.get(mutableKey);
		}
		fin = System.nanoTime();
		System.out.println("HashTable temps de recherche une fois mutée = "+ Math.abs(fin - debut) + " nano secondes");

		System.out.println(Objects.nonNull(res) ? "I find the result":"I do not find the result");

		assertNotNull(res,"Manage to match the key and value");
	}
	
	@Test
	public void shouldBeQuickerWithPersonalizeHashThanClassicImpl() {
		System.out.println("shouldBeQuickerWithPersonalizeHashThanClassicImpl");
		int iterationComparatifTest = iteration*2;
		Map<BeanWithHash,String> hashTable = new Hashtable<BeanWithHash,String>();
		BeanWithHash bean = null;
		long debut = System.nanoTime();
		Date now = new Date();
		List<String> owner =Arrays.asList("Martin","Paul");
		for (int i = 0; i < iterationComparatifTest; i++) {
			bean = new BeanWithHash(i,true,"aName"+i,now,owner);
			hashTable.put(bean,bean.toString());
		}
		
		bean = new BeanWithHash(3504,true,"aName3504",now,owner);
		String res = null;
		debut = System.nanoTime();
		if (hashTable.containsKey(bean)) {
			res=hashTable.get(bean);
		}
		long fin = System.nanoTime();
		long searchTimeClassicHash=Math.abs(fin - debut);

		System.out.println("HashTable temps de recherche pour BeanWithHash  = "+ searchTimeClassicHash+ " ms");
		
		/////////////////////////
		
		hashTable.clear();
		BeanWithPersonalizedHashImmutable bean2 = null;
		Map<BeanWithPersonalizedHashImmutable,String> hashTable2 = new Hashtable<BeanWithPersonalizedHashImmutable,String>();
		for (int i = 0; i < iterationComparatifTest; i++) {
			bean2 = new BeanWithPersonalizedHashImmutable(i,true,"aName"+i,now,owner);
			hashTable2.put(bean2,bean2.toString());
		}
		
		bean2 = new BeanWithPersonalizedHashImmutable(3504,true,"aName3504",now,owner);
		res = null;
		debut = System.nanoTime();
		if (hashTable2.containsKey(bean2)) {
			res=hashTable2.get(bean2);
		}
		fin = System.nanoTime();
				
		long searchTimePersonalizeHash=Math.abs(fin - debut);
		System.out.println("HashTable temps de recherche pour BeanWithPersonalizedHashImmutable  = "+ searchTimePersonalizeHash + " ms");
		assertTrue(searchTimeClassicHash>searchTimePersonalizeHash,"Manage to match the key and value");
	}
	
}
