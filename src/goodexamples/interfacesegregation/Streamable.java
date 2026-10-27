package goodexamples.interfacesegregation;

// Small, focused interface: only digital items that can be streamed implement it.
public interface Streamable {

    String generateStreamingUrl(String memberId);

}
