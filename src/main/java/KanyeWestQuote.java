import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class KanyeWestQuote {
    public String quote;

    public KanyeWestQuote(@JsonProperty("quote") String quote) {
        this.quote = quote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof KanyeWestQuote that)) return false;
        return quote.equals(that.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quote);
    }

    @Override
    public String toString() {
        return "KanyeWestQuote{" +
                "quote='" + quote + '\'' +
                '}';
    }
}
