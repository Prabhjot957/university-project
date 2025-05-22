import com.mycompany.CPM_subsystem.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import org.junit.Test;


public class SearchServiceTest {

    @Test
    public void testCustomerRegistration() {
        Customer customer = new Customer("C001", "John Doe", "1234567890", "johndoe@example.com", "123 Street, City", true);
        assertEquals("John Doe", customer.getName());
        assertTrue(customer.isActive());
    }

    @Test
    public void testPetRegistration() {
        Customer customer = new Customer("C001", "John Doe", "1234567890", "johndoe@example.com", "123 Street, City", true);
        Pet pet = new Pet("P001", "Rex", "Labrador", "Large", 5, "None", "Friendly", customer);
        assertEquals("Rex", pet.getName());
        assertEquals("Labrador", pet.getBreed());
    }

    @Test
    public void testGroomingRecord() {
        GroomingRecord groomingRecord = new GroomingRecord("GR001", new Date(), "Full Groom", "Cleaned and styled the pet");
        assertNotNull(groomingRecord.getDate());
        assertEquals("Full Groom", groomingRecord.getServiceType());
    }

    @Test
    public void testSearchCustomer() {
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer("C001", "John Doe", "1234567890", "johndoe@example.com", "123 Street, City", true);
        customers.add(customer);
        SearchService searchService = new SearchService(customers, new ArrayList<>());

        Customer foundCustomer = searchService.searchCustomer("John Doe", null, null);
        assertNotNull(foundCustomer);
        assertEquals("John Doe", foundCustomer.getName());
    }

    @Test
    public void testPreventDuplicateCustomerEntry() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("C001", "John Doe", "1234567890", "johndoe@example.com", "123 Street, City", true);
        Customer customer2 = new Customer("C002", "Jane Smith", "0987654321", "janesmith@example.com", "456 Avenue, City", true);
        customers.add(customer1);

        SearchService searchService = new SearchService(customers, new ArrayList<>());

        boolean isAdded = searchService.preventDuplicateCustomerEntry(customer2);
        boolean isDuplicate = !searchService.preventDuplicateCustomerEntry(customer1);

        assertTrue(isAdded);
        assertFalse(isDuplicate);
    }
}
