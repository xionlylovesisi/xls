package price;

import price.ReferencePrice;

public interface ReferencePriceMapper {
    int insert(ReferencePrice record);

    int insertSelective(ReferencePrice record);
}