package abra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Utility class for outputting fastq files
 * 
 * @author Lisle Mose (lmose at unc dot edu)
 */
public class FastqOutputFile {
    private BufferedWriter writer;
    
    public void init(String filename) throws IOException {
    	
    	GZIPOutputStream zip = new GZIPOutputStream(new FileOutputStream(new File(filename)));
        writer = new BufferedWriter(new OutputStreamWriter(zip, "UTF-8"));
    }
    
    public void write(FastqRecord record) throws IOException {
        for (int i = 0; i<record.getLines().length; i++) {
            writer.write(record.getLines()[i]);
            writer.write('\n');
        }
    }
    
    public void close() throws IOException {
        writer.close();
    }
}

