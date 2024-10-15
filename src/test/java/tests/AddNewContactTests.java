package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase {


    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .withEmail("mara@gmail.com")
                    .withPassword("Mmar123456$"));
        }
    }

    @Test
    public void addContactSuccessAllFields() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("Tony"+i)
                .lastName("Stark")
                .phone("34343434"+i)
                .email("stark"+i+"@gmail.com")
                .address("NY")
                .description("all fields")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().getScreen("src/test/screenshots/screen-"+i+".png");
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));


    }

    @Test
    public void addContactSuccessReqFields() {

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Contact contact = Contact.builder()
                .name("TonyReq"+i)
                .lastName("Stark")
                .phone("34343434"+i)
                .email("stark"+i+"@gmail.com")
                .address("NY")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddedByPhone(contact.getPhone()));
    }

@Test
    public void addNewContactWrongName(){
    Contact contact = Contact.builder()
            .name("")
            .lastName("Stark")
            .phone("343434343434")
            .email("stark@gmail.com")
            .address("NY")
            .description("empty name")
            .build();

    app.getHelperContact().openContactForm();
    app.getHelperContact().fillContactForm(contact);
    //app.getHelperContact().pause(15000);
    app.getHelperContact().saveContact();

    Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
}

    @Test
    public void addNewContactWrongAddress(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("343434343434")
                .email("stark@gmail.com")
                .address("")
                .description("empty address")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongLastName(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("")
                .phone("343434343434")
                .email("stark@gmail.com")
                .address("NY")
                .description("empty last name")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());

    }

    @Test
    public void addNewContactWrongPhone(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("")
                .email("stark@gmail.com")
                .address("NY")
                .description("empty phone")

                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact()
                .isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));

    }

    @Test
    public void addNewContactWrongEmail(){
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("343434343434")
                .email("starkgmail.com")
                .address("NY")
                .description("wrong email")
                .build();

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        //app.getHelperContact().pause(15000);
        app.getHelperContact().saveContact();
        Assert.assertTrue(app.getHelperContact().isAddContactPageStillDisplayed());
        Assert.assertTrue(app.getHelperContact()
                .isAlertPresent("Email not valid:"));


    }

}
