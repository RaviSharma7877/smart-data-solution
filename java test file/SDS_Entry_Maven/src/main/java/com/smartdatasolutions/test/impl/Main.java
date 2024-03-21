package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main class for converting member data from a file to CSV format.
 */
public class Main extends MemberFileConverter {

    @Override
    protected MemberExporter getMemberExporter() {
        return new MemberExporterImpl();
    }

    @Override
    protected MemberImporter getMemberImporter() {
        return new MemberImporterImpl();
    }

    /**
     * Remove duplicate members from the list.
     *
     * @param membersFromFile List of members read from the input file
     * @return List of non-duplicate members
     */
    @Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
        List<Member> nonDuplicateMembers = new ArrayList<>();
        for (Member member : membersFromFile) {
            if (!nonDuplicateMembers.contains(member)) {
                nonDuplicateMembers.add(member);
            }
        }
        return nonDuplicateMembers;
    }

    /**
     * Split members by state.
     *
     * @param validMembers List of valid members (non-duplicate)
     * @return Map containing lists of members grouped by state
     */
    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
        Map<String, List<Member>> membersByState = new HashMap<>();
        for (Member member : validMembers) {
            String state = member.getState();
            if (!membersByState.containsKey(state)) {
                membersByState.put(state, new ArrayList<>());
            }
            membersByState.get(state).add(member);
        }
        return membersByState;
    }

    /**
     * Convert the input member file to CSV format.
     *
     * @param inputMemberFile  Input file containing member data
     * @param outputFilePath   Output directory path for CSV files
     * @param outputFileName   Output file name for CSV files
     * @throws Exception If an error occurs during conversion
     */
    @Override
    public void convert(File inputMemberFile, String outputFilePath, String outputFileName) throws Exception {
        MemberImporter memberImporter = getMemberImporter();
        List<Member> membersFromFile = memberImporter.importMembers(inputMemberFile);

        List<Member> validMembers = getNonDuplicateMembers(membersFromFile);

        Map<String, List<Member>> membersByState = splitMembersByState(validMembers);

        for (Map.Entry<String, List<Member>> entry : membersByState.entrySet()) {
            String state = entry.getKey();
            List<Member> membersPerState = entry.getValue();

            File outputFile = new File(outputFilePath + File.separator + state + "_" + outputFileName);

            try (FileWriter fileWriter = new FileWriter(outputFile);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                // Write CSV header
                bufferedWriter.write("id,first name,last name,address,city,state,zip");
                bufferedWriter.newLine();

                // Write members to CSV
                for (Member member : membersPerState) {
                    bufferedWriter.write(member.toCSVString());
                    bufferedWriter.newLine();
                }
            }
        }
    }

    /**
     * Main method to run the conversion process.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Main main = new Main();
        File inputMemberFile = new File("Members.txt");
        String outputFilePath = System.getProperty("user.dir");
        String outputFileName = "output.csv";
        try {
            main.convert(inputMemberFile, outputFilePath, outputFileName);
        } catch (Exception e) {
            System.err.println("Error converting file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
