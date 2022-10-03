import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class KanyeWestQuoteReader {
    private static final String QUOTE_URL = "https://api.kanye.rest";
    private static final String OLD_QUOTE = "Stary cytat: ";
    private static final String NEW_QUOTE = "Nowy cytat: ";
    private static final String ACCEPT_HEADER = "accept";
    private static final String APPLICATION_JSON = "application/json";

    private final URL url;
    private final Set<KanyeWestQuote> existingKayneWestQuotes;

    public KanyeWestQuoteReader() throws MalformedURLException {
        url = new URL(QUOTE_URL);
        existingKayneWestQuotes = new HashSet<>();
    }

    public String readQuote() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty(ACCEPT_HEADER, APPLICATION_JSON);
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        KanyeWestQuote response = mapper.readValue(responseStream, KanyeWestQuote.class);
        if (existingKayneWestQuotes.contains(response)) {
            return OLD_QUOTE + response.quote;
        } else {
            existingKayneWestQuotes.add(response);
            return NEW_QUOTE + response.quote;
        }
    }
}
