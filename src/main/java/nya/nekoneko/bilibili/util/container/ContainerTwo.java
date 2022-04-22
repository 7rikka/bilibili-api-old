package nya.nekoneko.bilibili.util.container;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ho
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContainerTwo<A, B> {
    private A indexA;
    private B indexB;
}
