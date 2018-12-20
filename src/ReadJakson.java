import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJakson {
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./src/Test.json"));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	          
	       ObjectMapper mapper = new ObjectMapper();
	       ResultWrapper wraper = mapper.readValue(sb.toString(), ResultWrapper.class);
	       
	       List<Result> result = wraper.getResult();
	       
	       result.forEach(e ->System.out.println(e.get_id()));
	       
	    } finally {
	        br.close();
	    }
	}
}
