package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343434343")
                .email("stark@gmil.com")
                .address("NY")
                .description("all fields")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("TonyReq")
                .lastName("Stark")
                .phone("56985642357")
                .email("stark111@gmil.com")
                .address("NY")
                .build()});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("123")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("12356598523641587566659495")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("wwwwwwwwwwww")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("$%*&)#%%%%%%%")
                .address("NY")
                .description("John")
                .build()});

        return list.iterator();
    }
}
