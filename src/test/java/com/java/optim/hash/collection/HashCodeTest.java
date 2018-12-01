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

import com.java.optim.hash.collection.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashCodeTest {

	private int iteration = 4000000;
	private int insertionRank= 235645;

	private List<String> owner = Arrays.asList("Martin", "Paul");

	@BeforeEach
	public void separation() {
		System.out.println("______________________________________");
	}

	// @BeforeAll
	public void initialPrint() {
		System.out.println("Iteration number:"+iteration);
		System.out.println("Insertion rank" + insertionRank);
	}

	
	@Test
	public void equality() {
		BeanWithHash bean = new BeanWithHash(154064, true, "aName53144", new Date(), owner);
		BeanWithHash bean2 = new BeanWithHash(154064, true, "aName53144", new Date(), owner);
		assertTrue(bean.equals(bean2));
	}
	
	@Test
	public void equality2() {
		BeanWithSameHashValue bean = new BeanWithSameHashValue(154064, true, "aName53144", new Date(), owner);
		BeanWithSameHashValue bean2 = new BeanWithSameHashValue(154064, true, "aName53144", new Date(), owner);
		assertTrue(bean.equals(bean2));
	}
	
	public <T extends RootBean> boolean executeTest(
			final Map<T,String> hashMap, 
			T keyInsert, 
			int totalIteration, 
			int insertionRank, 
			T specificKeyToSearch,
			boolean mutationActivated) {

		long begin = System.nanoTime();
		T bean;
		for (int i = 0; i < totalIteration; i++) {
			if (i == insertionRank) {
				bean = keyInsert;
			} else {
				bean = (T)keyInsert.clone();
				bean.setPrice(i);
				bean.setName("aName"+i);
			}
			hashMap.put(bean, bean.toString());
		}
		long end = System.nanoTime();
		System.out.println("HashTable insertion duration  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(end - begin)) + " ms");

		if(mutationActivated) {
			keyInsert.setCreation(new Date());
			keyInsert.setName("anOtherName");
			keyInsert.setPrice(-459);
		}

		//SEARCH
		begin = System.nanoTime();
		if(Objects.nonNull(specificKeyToSearch)) {
			keyInsert = specificKeyToSearch;
		}
		boolean isPresent = hashMap.containsKey(keyInsert);
		if(isPresent) {
			hashMap.get(keyInsert);
		}
		end = System.nanoTime();
		System.out.println("HashTable seek duration  = " + Math.abs(end - begin) + " ns");
		return isPresent;
	}

	@Test
	public void searchByReferenceForBeanWithoutHash() {
		System.out.println("searchByReferenceForBeanWithoutHash");
		Map<BeanWithoutHash, String> hashTable = new Hashtable<>();
		BeanWithoutHash bean = new BeanWithoutHash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because Object Reference is found");
		isPresentPrint(isPresent);
	}

	@Test
	public void searchCloneBeanForBeanWithoutHash() {
		System.out.println("searchCloneBeanForBeanWithoutHash");
		Map<BeanWithoutHash, String> hashTable = new Hashtable<>();
		int rank =iteration/2;
		Date date= new Date();
		BeanWithoutHash elementInsert = new BeanWithoutHash(rank, true, "aName"+rank, date, owner);
		BeanWithoutHash elementSearch = new BeanWithoutHash(rank, true, "aName"+rank, date, owner);

		boolean isPresent = executeTest(hashTable,elementInsert, iteration,-1,elementSearch,false);
		assertFalse(isPresent,"Hash does not manage to find entry because Object Reference is different");
		isPresentPrint(isPresent);
	}


	@Test
	public void searchBeanReferenceWithHash() {
		System.out.println("searchBeanReferenceWithHash");
		Map<BeanWithHash, String> hashTable = new Hashtable<>();
		BeanWithHash bean = new BeanWithHash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	@Test
	public void searchCloneBeanWithHash() {
		System.out.println("searchCloneBeanWithHash");
		Map<BeanWithHash, String> hashTable = new Hashtable<>();
		Date date = new Date();
		BeanWithHash insertedElement = new BeanWithHash(154064, true, "aName53144", date, owner);
		BeanWithHash copy = new BeanWithHash(154064, true, "aName53144", date, owner);

		boolean isPresent = executeTest(hashTable,insertedElement, iteration,insertionRank,copy,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	@Test
	public void testEclipseHashCodeImpl() {
		System.out.println("testEclipseHashCodeImpl");
		Map<BeanWithEclipseHash, String> hashTable = new Hashtable<>();
		BeanWithEclipseHash bean = new BeanWithEclipseHash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	@Test
	public void testIntelliJHashCodeImpl() {
		System.out.println("testIntelliJHashCodeImpl");
		Map<BeanWithIntelliJHash, String> hashTable = new Hashtable<>();
		BeanWithIntelliJHash bean = new BeanWithIntelliJHash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	@Test
	public void testJava8HashCodeImpl() {
		System.out.println("testJava8HashCodeImpl");
		Map<BeanWithJava8Hash, String> hashTable = new Hashtable<>();
		BeanWithJava8Hash bean = new BeanWithJava8Hash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	@Test
	public void changeValueForBeanWithHash() {
		System.out.println("changeValueForBeanWithHash");
		Map<BeanWithHash, String> hashTable = new Hashtable<>();
		BeanWithHash bean = new BeanWithHash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,true);
		assertFalse(isPresent,"Hash does not manage to find entry because fields had been change and hash does not match anymore");
		isPresentPrint(isPresent);
	}


	@Test
	public void testBeanWithSameHashValue() {
		System.out.println("testBeanWithSameHashValue");
		System.out.println("Should be slow because hashcode method return always the same value and the repartition is bad");

		Map<BeanWithSameHashValue, String> hashTable = new Hashtable<>();
		BeanWithSameHashValue bean = new BeanWithSameHashValue(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	@Test
	public void testCloneBeanWithSameHashValue() {
		System.out.println("testCloneBeanWithSameHashValue");
		System.out.println("Should be slow and not find the key");

		Map<BeanWithSameHashValue, String> hashTable = new Hashtable<>();
		Date date = new Date();
		BeanWithSameHashValue bean = new BeanWithSameHashValue(154064, true, "aName53144", date, owner);
		BeanWithSameHashValue copy = new BeanWithSameHashValue(154064, true, "aName53144", date, owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,copy,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	@Test
	public void testBeanWithHashImmutable() {
		System.out.println("testBeanWithHashImmutable");
		Map<BeanWithHashImmutable, String> hashTable = new Hashtable<>();
		BeanWithHashImmutable bean= new BeanWithHashImmutable(154064, true, "aName53144", new Date(), owner);
		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}



	@Test
	public void beCarefullWhenYouReimplementHashCodeMethod() {
		System.out.println("beCarefullWhenYouReimplementHashCodeMethod");
		System.out.println("Classical Implement with prime number");
		Map<BeanWithHash, String> hashTable = new Hashtable<>();
		BeanWithHash bean = new BeanWithHash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);

		System.out.println("Personalize Implement");
		Map<BeanWithPersonalizedHash, String> dangerousHashTable = new Hashtable<>();
		BeanWithPersonalizedHash anOtherbean = new BeanWithPersonalizedHash(154064, true, "aName53144", new Date(), owner);

		boolean isPresent2 = executeTest(dangerousHashTable,anOtherbean, iteration,insertionRank,null,false);
		assertTrue(isPresent2,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent2);
	}


	@Test
	public void testImmutableCachingHashCode() {
		System.out.println("testImmutableCachingHashCode");
		Map<BeanImmutableWithCachingHashCode, String> hashTable = new Hashtable<>();
		BeanImmutableWithCachingHashCode bean = new BeanImmutableWithCachingHashCode(154064, true, "aName53144", new Date(), owner);
		boolean isPresent = executeTest(hashTable,bean, iteration,insertionRank,null,false);
		assertTrue(isPresent,"Hash manage to find entry because hash method is defined");
		isPresentPrint(isPresent);
	}

	private void isPresentPrint(boolean isPresent) {
		System.out.println((isPresent)?"Value is found":"Value not found");
	}


}
