package mx.com.garnet;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@Transactional
//@RunWith(SpringRunner.class)
//@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class TestRepository {
    /*@Autowired
    private TestEntityManager entityManager;

    @Autowired
    CatStatusExampleRepository repository;

    @Transactional
    @Test
    public void TestRepository(){
        CatStatusExample cat = new CatStatusExample("Prueba 4");
        entityManager.persist(cat);
        entityManager.flush();
        assertNotNull(cat);

        cat = repository.findById(8);
        if(cat != null){
            System.out.printf("Detalle[" + cat.getDetalle() +"]");
        }

    }*/

    public CatalogoResponse obtenerCatalogo(CatalogoRequest request){

    }
}
