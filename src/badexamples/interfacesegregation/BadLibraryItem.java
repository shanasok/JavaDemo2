package badexamples.interfacesegregation;

/*
* Example of an interface that violates the Interface Segregation Principle (ISP).
* Clients should not be forced to depend on methods they do not use.
*/
public interface BadLibraryItem {

    // ❌ VIOLATION: One "fat" interface mixes physical and digital capabilities.
    // Every item has to implement all of these, even when they make no sense for it.
    String getShelfLocation();

    double getShippingWeightPounds();

    String generateStreamingUrl(String memberId);

}
