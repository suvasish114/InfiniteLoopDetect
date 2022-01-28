package infinite;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InfiniteDetect {
	private Scanner scan;
	private Set<Integer> infiniteLoops = new HashSet<Integer>();
	private int counter=0;	// line counter
	
	// constructor
	public InfiniteDetect(String inputFile) {
		scan = new ReadInput(inputFile).getScan();
	}
	
	// close fields
	private void close() {
		this.scan.close();
	}
	
	// get lines
	public Set<Integer> getLines(){
		infiniteForDetect();
		return infiniteLoops;
	}
	
	// infinite detector
	private void infiniteForDetect() {
		String line;
		while(scan.hasNextLine()) {
			int forCounter =0;
			
			counter++;
			line = scan.nextLine();
			
			// inside a for loop
			if(line.trim().startsWith("for")) {
				boolean flag=true;
				String variableName=getVariableName(line);
				int variableValue = getVariableValue(line);
				int variableConditionValue=getConditionValue(line, variableName);
				
				// iterate through for loop
				while(flag) {
					if((variableValue > variableConditionValue && line.contains(String.valueOf(variableName+"-")))
							|| (variableValue < variableConditionValue && line.contains(String.valueOf(variableName+"+")))) {
						flag = false;
					}
					else {
						infiniteLoops.add(counter);
					}
					if(line.trim().endsWith("}")) flag=false;
					forCounter++;
					line = scan.nextLine();
				}
				counter += forCounter;
			}
		}
		close();
	}
	
	// fetch variable name
	private String getVariableName(String line) {
		return line.trim().substring(line.trim().indexOf("(")+1, line.trim().indexOf("="));
	}
	
	// fetch variable value
	private int getVariableValue(String line) {
		return Integer.parseInt(line.trim().substring(line.trim().indexOf("=")+1, line.trim().indexOf(";")));
	}
	
	// fetch condition value
	private int getConditionValue(String line, String variable) {
		String str = line.trim().substring(line.trim().indexOf(";")+1);
		if(str.contains(">") || str.contains("<")) {
			return Integer.parseInt(str.trim().substring(variable.length()+1, str.trim().indexOf(";")));
		}
		return Integer.parseInt(str.trim().substring(variable.length()+2, str.trim().indexOf(";")));
	}
}
