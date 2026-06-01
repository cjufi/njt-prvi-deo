package rs.ac.bg.fon.njt.njt_11_05_2026.converter;

/**
 *
 * @author Filip
 */
public interface Converter<Dto,Entity> {
    Entity toEntity(Dto dto);
    Dto toDto(Entity entity);
}
