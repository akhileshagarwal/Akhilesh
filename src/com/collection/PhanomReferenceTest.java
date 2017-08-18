package com.collection;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhanomReferenceTest {

	public static void main(String[] args) throws InterruptedException {
		ReferenceQueue<String> refQueue = new ReferenceQueue<>();
		String s2 = new String("Agarwal");
		PhantomReference<String> phantom = new PhantomReference<String>(s2, refQueue);
		s2=null;
		System.gc();
		Thread.currentThread().sleep(1000);
		System.out.println(phantom.isEnqueued());
		System.out.println(refQueue.poll().get());
		System.out.println(phantom.isEnqueued());
		System.out.println(phantom.get());
		System.out.println(refQueue.toString());
	}

}
