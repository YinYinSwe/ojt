package ojt.student.bl.service.person.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ojt.student.bl.service.person.PersonService;
import ojt.student.persistence.dao.student.PersonDao;
import ojt.student.persistence.entity.Person;
import ojt.student.web.form.PersonForm;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDAO;

    /**
     * <h2>getPersonList</h2>
     * <p>
     * 
     * </p>
     * 
     * @return
     */
    @Override
    @Transactional
    public List<Person> getPersonList() {
        return personDAO.getPersonList();
    }

    /**
     * <h2>addPerson</h2>
     * <p>
     * 
     * </p>
     * 
     * @param personform
     */
    @Override
    @Transactional
    public void addPerson(PersonForm personform) {
        Person person = new Person(personform);
        this.personDAO.addPerson(person);

    }

    /**
     * <h2>deletePerson</h2>
     * <p>
     * 
     * </p>
     * 
     * @param personId
     */
    @Override
    public void deletePerson(Integer personId) {
        personDAO.deletePerson(personId);

    }

    /**
     * <h2>getPerson</h2>
     * <p>
     * 
     * </p>
     * 
     * @param empid
     * @return
     */
    @Override
    public PersonForm getPerson(int empid) {
        Person resultPost = this.personDAO.getPerson(empid);
        PersonForm resultPostform = resultPost != null ? new PersonForm(resultPost) : null;
        return resultPostform;
    }

    /**
     * <h2> updatePerson </h2>
     * <p>
     * 
     * </p>
     * 
     * @param personForm
     */
    @Override
    public void updatePerson(PersonForm personForm) {
        Person update = this.personDAO.getPerson(personForm.getId());
        update.setName(personForm.getName());
        update.setCountry(personForm.getCountry());
        this.personDAO.updatePerson(update);

    }

}
