package com.java.optim.hashcode.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class HashCodeTest {

	@Test
	public void shouldBeSlow() {
		Map<BeanWithoutHash,String> hashTable = new Hashtable<BeanWithoutHash,String>();
		BeanWithoutHash bean = null;
		long debut = System.nanoTime();
		Date now = new Date();
		List<String> owner =Arrays.asList("Martin","Paul");
		for (int i = 0; i < 20000; i++) {
			bean = new BeanWithoutHash(i,true,"aName"+i,now,owner);
			hashTable.put(bean,bean.toString());
		}
		long fin = System.nanoTime();
		System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");
		debut = System.nanoTime();
		bean = new BeanWithoutHash(3504,true,"aName3504",now,owner);

		if (hashTable.containsKey(bean)) {
			System.out.println(hashTable.get(bean));
		}
		fin = System.nanoTime();
		System.out.println("HashTable temps de recherche = "+ TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");
	}

}
