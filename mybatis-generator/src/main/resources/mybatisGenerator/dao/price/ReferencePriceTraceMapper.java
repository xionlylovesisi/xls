package price;

import price.ReferencePriceTrace;

public interface ReferencePriceTraceMapper {
    int insert(ReferencePriceTrace record);

    int insertSelective(ReferencePriceTrace record);
}