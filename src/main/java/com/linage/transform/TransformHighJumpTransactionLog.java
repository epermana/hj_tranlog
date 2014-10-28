package com.linage.transform;
import java.util.LinkedHashMap;

import com.linage.mapping.MappingReader;
/**
 * This class builds the transformation SQL to Impala
 * @author Edwin Permana
 *
 */
public class TransformHighJumpTransactionLog {
	  private String mappingconfigFile = "highjump_t_tran_log_mapping.properties";
	  private String transformconfigFile= "highjump_t_tran_log_transform.properties";

//	  /**FOR TESTING SQL
//	   * @param args
//	   * @throws SQLException
//	   */
	  public static void main(String[] args) {
	  //Test SQL
		  TransformHighJumpTransactionLog tt =  new TransformHighJumpTransactionLog();
		  System.out.println(tt.buildSQL());
	  }
	
	  /**
	   * 
	   * @return String of SQL to execute transformation
	   */
	  public String buildSQL(){
		  MappingReader readMapping= new MappingReader();		
		  MappingReader readTransform= new MappingReader();
		 
			LinkedHashMap<String, String> highjumpTable = readMapping.readPropertyFile(this.transformconfigFile);
			LinkedHashMap<String,String> highjumpMap = readTransform.readPropertyFile(this.mappingconfigFile );
		  
		  StringBuffer insert = new StringBuffer("Insert into table ");
		  insert.append(highjumpTable.get("destination_table"));
		  insert.append("\n");
		  insert.append("select  \n");
		 
		  for (String key : highjumpMap.keySet()) {
			  insert.append(highjumpMap.get(key));
			  insert.append(" as ");insert.append(key);
			  insert.append(",\n");
			}
		  if (insert.length() > 0) {
			   insert.setLength(insert.length() - 2);
			}
		  
		  insert.append(" from ");
		  insert.append(highjumpTable.get("source_table"));
		  
		  
		  return insert.toString();
	  }
	  
	

}
