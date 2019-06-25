package ru.job4j.jdbc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class StoreXml {

    private File target;

    public StoreXml(File target) {
        this.target = target;
    }

    // сохраняет данные из list в файл target
    public void save(List<Entry> list) {

        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(new Entries(list), target);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
