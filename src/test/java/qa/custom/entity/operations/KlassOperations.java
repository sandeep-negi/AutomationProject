package qa.custom.entity.operations;
import lombok.extern.log4j.Log4j2;
import qa.context.EntityContext;

@Log4j2
public class KlassOperations {

    private final EntityContext entityContext;
    public KlassOperations(EntityContext entityContext){
        this.entityContext = entityContext;
    }

}
