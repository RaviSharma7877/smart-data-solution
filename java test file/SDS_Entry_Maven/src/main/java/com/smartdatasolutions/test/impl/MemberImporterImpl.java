package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the MemberImporter interface for importing members from a file.
 */
public class MemberImporterImpl implements MemberImporter {

    /**
     * Import members from a file and return a list of Member objects.
     *
     * @param inputFile The file containing member data
     * @return A list of Member objects imported from the file
     * @throws Exception If an error occurs during import
     */
	@Override
	public List<Member> importMembers(File inputFile) throws Exception {
	    List<Member> importedMembers;

	    try (Stream<String> lines = Files.lines(inputFile.toPath())) {
	        importedMembers = lines.map(line -> line.split("\\s{2,}|\\s*,\\s*"))
	                .filter(parts -> parts.length == 7)
	                .map(parts -> {
	                    Member member = new Member();
	                    member.setId(parts[0].trim());
	                    member.setFirstName(parts[1].trim());
	                    member.setLastName(parts[2].trim());
	                    member.setAddress(parts[3].trim());
	                    member.setCity(parts[4].trim());
	                    member.setState(parts[5].trim());
	                    member.setZip(parts[6].trim());
	                    return member;
	                })
	                .collect(Collectors.toList());
	    }

	    return importedMembers;
	}


}
