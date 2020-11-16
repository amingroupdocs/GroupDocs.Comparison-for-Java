package com.groupdocs.comparison.examples.advanced_usage.comparison;

import com.groupdocs.comparison.Comparer;
import com.groupdocs.comparison.examples.SampleFiles;
import com.groupdocs.comparison.examples.Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This example demonstrates comparing of multi documents
 */
public class CompareMultipleDocumentsStream {
    public static void run() throws Exception {

        String outputFileName = Utils.getOutputDirectoryPath(SampleFiles.RESULT_WORD, "CompareMultipleDocumentsStream");

        try (InputStream sourceStream = new FileInputStream(SampleFiles.SOURCE_WORD);
             InputStream target1Stream = new FileInputStream(SampleFiles.TARGET1_WORD);
             InputStream target2Stream = new FileInputStream(SampleFiles.TARGET2_WORD);
             InputStream target3Stream = new FileInputStream(SampleFiles.TARGET3_WORD);
             OutputStream resultStream = new FileOutputStream(outputFileName);
             Comparer comparer = new Comparer(sourceStream)) {

            {
                // Note: It is the same with commented code below
                comparer.add(target1Stream, target2Stream, target3Stream);
                // Note: It is the same with the code above
//                comparer.add(new FileInputStream(SampleFiles.TARGET_WORD));
//                comparer.add(new FileInputStream(SampleFiles.TARGET2_WORD));
//                comparer.add(new FileInputStream(SampleFiles.TARGET3_WORD));
            }
            comparer.compare(resultStream);
        }
        System.out.println("\nDocuments compared successfully.\nCheck output in " + Utils.OUTPUT_PATH + ".");
    }
}