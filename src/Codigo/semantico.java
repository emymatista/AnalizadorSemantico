/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author emyma
 */

class SymbolTable {
    private final Map<String, String> variables;

    public SymbolTable() {
        variables = new HashMap<>();
    }

    public void addVariable(String identifier, String type) {
        variables.put(identifier, type);
    }

    public boolean containsVariable(String identifier) {
        return variables.containsKey(identifier);
    }

    public String getType(String identifier) {
        return variables.get(identifier);
    }
}

public class semantico{
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SymbolTable symbolTable = new SymbolTable();

        while (true) {
            System.out.print("Enter a variable declaration (e.g., int x;): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            // Split input into data type and variable name
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.err.println("Invalid input format. Please use 'datatype variableName;'.");
                continue;
            }

            String dataType = parts[0].trim();
            String variableName = parts[1].replace(";", "").trim();

            if (symbolTable.containsVariable(variableName)) {
                System.err.println("Error: Variable '" + variableName + "' already declared.");
            } else {
                symbolTable.addVariable(variableName, dataType);
                System.out.println("Variable '" + variableName + "' of type '" + dataType + "' added to symbol table.");
            }
        }

        scanner.close();
    }
}

/*
class SymbolTable {
    private Map<String, String> variables;

    public SymbolTable() {
        variables = new HashMap<>();
    }

    public void addVariable(String identifier, String type) {
        variables.put(identifier, type);
    }

    public boolean containsVariable(String identifier) {
        return variables.containsKey(identifier);
    }

    public String getType(String identifier) {
        return variables.get(identifier);
    }
}

class SemanticAnalyzer {
    private SymbolTable symbolTable;

    public SemanticAnalyzer() {
        symbolTable = new SymbolTable();
    }

    public void analyzeAssignment(String identifier, String type) {
        if (symbolTable.containsVariable(identifier)) {
            String existingType = symbolTable.getType(identifier);
            if (!existingType.equals(type)) {
                System.err.println("Error: Type mismatch for variable '" + identifier + "'.");
            }
        } else {
            symbolTable.addVariable(identifier, type);
        }
    }

    public static void main(String[] args) {
        //SemanticAnalyzer analyzer = new SemanticAnalyzer();

        // Example: int x = 10;
        //analyzer.analyzeAssignment("x", "int");

        // Example: float y = x * 30;
        //analyzer.analyzeAssignment("y", "float");

        // Example: boolean flag = true;
        //analyzer.analyzeAssignment("flag", "boolean");

        // Example: char ch = 'A';
        //analyzer.analyzeAssignment("ch", "char");

        // Example: int result = x + y; // Type mismatch error
        //analyzer.analyzeAssignment("result", "int");
    }
}

*/

