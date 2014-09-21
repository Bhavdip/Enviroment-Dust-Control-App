package com.android.edc.util;

import com.android.edc.bean.DustJobData;
import com.android.edc.bean.OperatoData;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

/**
 * DatabaseConfigUtl writes a configuration file to avoid using Annotation
 * processing in runtime. This gains a noticeable performance improvement.
 * configuration file is written to /res/raw/ by default.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {

	private static Class<?>[] collectionDAO = new Class<?>[] { DustJobData.class, OperatoData.class };

	public static void main(String arg[]) {
		try {
			writeConfigFile("ormlite_config.txt", collectionDAO);
			
		} catch (Exception e) {}
	}
}
