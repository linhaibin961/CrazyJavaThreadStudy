package test;

import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

/**
 * Created by linhaibin on 2018/5/17.
 */
public class Instance {
	public static Interner<String> lockPool = Interners.newWeakInterner();


}
