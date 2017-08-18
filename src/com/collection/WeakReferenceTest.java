package com.collection;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakReferenceTest {

	public static void main(String[] args) {
		String s = new String("Akhilesh");
		
		
		WeakReference<String> ref = new WeakReference<String>(s);
		System.out.println(ref.get());
		s = null;
		System.gc();
		System.out.println(ref.get());
		
	}

}
