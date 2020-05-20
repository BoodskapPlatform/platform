package io.boodskap.iot.spi.storage.jpa.dao.util;

import java.math.BigInteger;

import org.apache.commons.lang3.StringUtils;

public class DBUtil {

	public static long toCount(Object result) {
		if(result instanceof Long) {
			return((Long)result).longValue();
		}else if(result instanceof BigInteger) {
			return ((BigInteger)result).longValue();
		}{
			return ((Integer)result).longValue();
		}
	}
	
	public static String searchToQuery(String search) {
		
		if(search.startsWith("[") && search.endsWith("]")) {
			return search.substring(1, search.length()-1).trim();
		}
		
		StringBuilder sb = new StringBuilder();
		
		String[] words =  StringUtils.split(search);
		
		for(String word : words) {
			
			if(word.contains("::")) { //LIKE %<text>%
				String fvals[] = StringUtils.split(word, "::");
				String query = String.format("lower(v.%s) like lower('%s')", fvals[0], "%"+fvals[1]+"%");
				sb.append(query).append(" ");
			}else if(word.contains(":")) { //LIKE <text>%
				String fvals[] = StringUtils.split(word, ":");
				String query = String.format("lower(v.%s) like lower('%s')", fvals[0], fvals[1]+"%");
				sb.append(query).append(" ");
			}else if(word.contains("|")) { //LIKE %<text>
				String fvals[] = StringUtils.split(word, "|");
				String query = String.format("lower(v.%s) like lower('%s')", fvals[0], "%"+fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("<=")) { //LESS THEN EQUALS
				String fvals[] = StringUtils.split(word, "<=");
				String query = String.format("v.%s <= %s", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains(">=")) { //GREATER THAN EUQALS
				String fvals[] = StringUtils.split(word, ">=");
				String query = String.format("v.%s >= %s", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("<")) { //LESS THAN
				String fvals[] = StringUtils.split(word, "<");
				String query = String.format("v.%s < %s", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains(">")) { //GREATER THAN
				String fvals[] = StringUtils.split(word, ">");
				String query = String.format("v.%s > %s", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("!=")) { //NOT EQUALS
				String fvals[] = StringUtils.split(word, "!=");
				String query = String.format("v.%s != %s", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("<>")) { //NOT EQUALS
				String fvals[] = StringUtils.split(word, "!=");
				String query = String.format("v.%s != %s", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("=")) { //EQUALS
				String fvals[] = StringUtils.split(word, "=");
				String query = String.format("v.%s = %s", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("[]")) { //IN
				String fvals[] = StringUtils.split(word, "[]");
				String query = String.format("v.%s in (%s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else {
				sb.append(word).append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public static String searchDataToQuery(String search) {
		
		if(search.startsWith("[") && search.endsWith("]")) {
			return search.substring(1, search.length()-1).trim();
		}
		
		StringBuilder sb = new StringBuilder();
		
		String[] words =  StringUtils.split(search);
		
		for(String word : words) {
			
			if(word.contains("::")) {
				String fvals[] = StringUtils.split(word, "::");
				String query = String.format("(v.id.name='%s' and lower(v.value) like lower('%s'))", fvals[0], "%"+fvals[1]+"%");
				sb.append(query).append(" ");
			}else if(word.contains(":")) {
				String fvals[] = StringUtils.split(word, ":");
				String query = String.format("(v.id.name='%s' and lower(v.value) like lower('%s'))", fvals[0], fvals[1]+"%");
				sb.append(query).append(" ");
			}else if(word.contains("|")) {
				String fvals[] = StringUtils.split(word, "|");
				String query = String.format("(v.id.name='%s' and lower(v.value) like lower('%s'))", fvals[0], "%"+fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("<=")) {
				String fvals[] = StringUtils.split(word, "<=");
				String query = String.format("(v.id.name='%s' and v.nvalue <= %s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains(">=")) {
				String fvals[] = StringUtils.split(word, ">=");
				String query = String.format("(v.id.name='%s' and v.nvalue >= %s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("<")) {
				String fvals[] = StringUtils.split(word, "<");
				String query = String.format("(v.id.name='%s' and v.nvalue < %s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains(">")) {
				String fvals[] = StringUtils.split(word, ">");
				String query = String.format("(v.id.name='%s' and v.nvalue > %s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("!=")) {
				String fvals[] = StringUtils.split(word, "!=");
				String query = String.format("(v.id.name='%s' and v.nvalue != %s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("<>")) {
				String fvals[] = StringUtils.split(word, "<>");
				String query = String.format("(v.id.name='%s' and v.nvalue != %s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("=")) {
				String fvals[] = StringUtils.split(word, "=");
				String query = String.format("(v.id.name='%s' and v.nvalue = %s)", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else if(word.contains("[]")) {
				String fvals[] = StringUtils.split(word, "[]");
				String query = String.format("(v.id.name='%s' and v.nvalue in (%s))", fvals[0], fvals[1]);
				sb.append(query).append(" ");
			}else {
				sb.append(word).append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(DBUtil.searchToQuery("name::0ct and pressure<100 and state[]12,15,78"));
	}
}
