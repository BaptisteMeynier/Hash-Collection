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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HashCodeTest {

    private int iteration = 50000;

    private List<String> owner = Arrays.asList("Martin", "Paul");

    @Test
    public void testWithBeanWithoutHash() {
        System.out.println("testWithBeanWithoutHash");

        Map<BeanWithoutHash, String> hashTable = new Hashtable<>();
        BeanWithoutHash beanToSearch = new BeanWithoutHash(154064, true, "aName53144", new Date(), owner);
        BeanWithoutHash bean;

        //INSERTION
        long debut = System.nanoTime();
        for (int i = 0; i < iteration; i++) {
            if (i == 2365) {
                bean = beanToSearch;
            } else {
                bean = new BeanWithoutHash(i, true, "aName" + i, new Date(), owner);
            }
            hashTable.put(bean, bean.toString());
        }
        long fin = System.nanoTime();
        System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");


        //SEARCH
        debut = System.nanoTime();
        boolean isPresent = hashTable.containsKey(beanToSearch);
        fin = System.nanoTime();

        System.out.println("HashTable temps de recherche = " + Math.abs(fin - debut) + " nano secondes");
        System.out.println(isPresent ? "I find the result" : "I do not find the result");
    }

    @Test
    public void testWithBeanWithHash() {
        System.out.println("testWithBeanWithHash");

        Map<BeanWithHash, String> hashTable = new Hashtable<>();
        BeanWithHash bean;

        //INSERT
        long debut = System.nanoTime();
        Date now = new Date();
        for (int i = 0; i < iteration; i++) {
            bean = new BeanWithHash(i, true, "aName" + i, new Date(), owner);
            hashTable.put(bean, bean.toString());
        }
        long fin = System.nanoTime();
        System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");


        //SEARCH
        debut = System.nanoTime();
        bean = new BeanWithHash(3504, true, "aName3504", now, owner);
        if (hashTable.containsKey(bean)) {
            hashTable.get(bean);
        }
        fin = System.nanoTime();
        System.out.println("HashTable temps de recherche = " + Math.abs(fin - debut) + " nanoSecondes");
    }

    @Test
    public void testWithBeanWithSameHashValue() {
        System.out.println("testWithBeanWithSameHashValue");
        System.out.println("Should be slow because hashcode method return always the same value and the repartition is bad");

        Map<BeanWithSameHashValue, String> hashTable = new Hashtable<>();
        BeanWithSameHashValue bean;
        Date now = new Date();

        long debut = System.nanoTime();
        for (int i = 0; i < iteration; i++) {
            bean = new BeanWithSameHashValue(i, true, "aName" + i, now, owner);
            hashTable.put(bean, bean.toString());
        }
        long fin = System.nanoTime();
        System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");


        debut = System.nanoTime();
        bean = new BeanWithSameHashValue(3504, true, "aName3504", now, owner);
        if (hashTable.containsKey(bean)) {
            hashTable.get(bean);
        }
        fin = System.nanoTime();
        System.out.println("HashTable temps de recherche = " + Math.abs(fin - debut) + " nano secondes");
    }


    @Test
    public void testBeanWithHashImmutable() {
        System.out.println("testBeanWithHashImmutable");
        Map<BeanWithHashImmutable, String> hashTable = new Hashtable<>();
        BeanWithHashImmutable bean;
        long debut = System.nanoTime();
        Date now = new Date();
        for (int i = 0; i < iteration; i++) {
            bean = new BeanWithHashImmutable(i, true, "aName" + i, now, owner);
            hashTable.put(bean, bean.toString());
        }
        long fin = System.nanoTime();
        System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");


        debut = System.nanoTime();
        bean = new BeanWithHashImmutable(3504, true, "aName3504", now, owner);
        String res = null;
        if (hashTable.containsKey(bean)) {
            res = hashTable.get(bean);
        }
        fin = System.nanoTime();
        System.out.println("HashTable temps de recherche = " + Math.abs(fin - debut) + " nano secondes");

        System.out.println(Objects.nonNull(res) ? "I find the result" : "I do not find the result");
    }

    @Test
    public void changeValueForBeanWithHash() {
        System.out.println("changeValueForBeanWithHash");

        Map<BeanWithHash, String> hashTable = new Hashtable<>();
        BeanWithHash mutableKey = new BeanWithHash(225546, true, "plouf", new Date(), owner);
        BeanWithHash bean;

        long debut = System.nanoTime();
        for (int i = 0; i < iteration; i++) {
            if (i == 2365) {
                bean = mutableKey;
            } else {
                bean = new BeanWithHash(i, true, "aName" + i, new Date(), owner);
            }
            hashTable.put(bean, bean.toString());
        }
        long fin = System.nanoTime();
        System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");

        debut = System.nanoTime();
        if (hashTable.containsKey(mutableKey)) {
            hashTable.get(mutableKey);
        }
        fin = System.nanoTime();
        System.out.println("HashTable temps de recherche = " + Math.abs(fin - debut) + " nano secondes");

        //BEGIN MUTATION
        mutableKey.setCreation(new Date());
        mutableKey.setOwner(new ArrayList<>());
        mutableKey.setPrice(-542671);
        mutableKey.setName("MUTATION");
        String res = null;
        debut = System.nanoTime();
        if (hashTable.containsKey(mutableKey)) {
            res = hashTable.get(mutableKey);
        }
        fin = System.nanoTime();
        System.out.println("HashTable temps de recherche une fois mutée = " + Math.abs(fin - debut) + " nano secondes");

        System.out.println(Objects.nonNull(res) ? "Find the result" : "Does not find the result");
    }

    @Test
    public void shouldBeQuickerWithPersonalizeHashThanClassicImpl() {
        System.out.println("shouldBeQuickerWithPersonalizeHashThanClassicImpl");

        Map<BeanWithHash, String> hashTable = new Hashtable<>();
        BeanWithHash bean;
        long debut;
        Date now = new Date();
        for (int i = 0; i < iteration; i++) {
            bean = new BeanWithHash(i, true, "aName" + i, now, owner);
            hashTable.put(bean, bean.toString());
        }

        bean = new BeanWithHash(3504, true, "aName3504", now, owner);
        debut = System.nanoTime();
        if (hashTable.containsKey(bean)) {
            hashTable.get(bean);
        }
        long fin = System.nanoTime();
        System.out.println("HashTable temps de recherche pour BeanWithHash  = " + Math.abs(fin - debut) + " ms");
        hashTable.clear();
        ////////////////////////

        BeanWithPersonalizedHashImmutable bean2;
        Map<BeanWithPersonalizedHashImmutable, String> hashTable2 = new Hashtable<>();
        for (int i = 0; i < iteration; i++) {
            bean2 = new BeanWithPersonalizedHashImmutable(i, true, "aName" + i, now, owner);
            hashTable2.put(bean2, bean2.toString());
        }

        bean2 = new BeanWithPersonalizedHashImmutable(3504, true, "aName3504", now, owner);
        debut = System.nanoTime();
        if (hashTable2.containsKey(bean2)) {
            hashTable2.get(bean2);
        }
        fin = System.nanoTime();

        System.out.println("HashTable temps de recherche pour BeanWithPersonalizedHashImmutable  = " + Math.abs(fin - debut) + " ms");
    }


    @Test
    public void testCachingHashCode() {
        System.out.println("testCachingHashCode");

        Map<BeanWithCachingHashCode, String> hashTable = new Hashtable<>();
        BeanWithCachingHashCode bean;
        long debut = System.nanoTime();
        Date now = new Date();

        for (int i = 0; i < iteration; i++) {
            bean = new BeanWithCachingHashCode(i, true, "aName" + i, now, owner);
            hashTable.put(bean, bean.toString());
        }
        long fin = System.nanoTime();
        System.out.println("HashTable temps d'insertion  = " + TimeUnit.NANOSECONDS.toMillis(Math.abs(fin - debut)) + " ms");


        String res = null;
        BeanWithCachingHashCode beanToSearch = new BeanWithCachingHashCode(3526, true, "aName3526", now, owner);
        debut = System.nanoTime();
        if (hashTable.containsKey(beanToSearch)) {
            res = hashTable.get(beanToSearch);
        }
        fin = System.nanoTime();
        System.out.println("HashTable temps de recherche = " + Math.abs(fin - debut) + " nano secondes");

        System.out.println(Objects.nonNull(res) ? "I find the result" : "I do not find the result");
    }


}
