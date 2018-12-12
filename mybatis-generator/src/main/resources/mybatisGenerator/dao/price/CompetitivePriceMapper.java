package price;

import price.CompetitivePrice;

public interface CompetitivePriceMapper {
    int insert(CompetitivePrice record);

    int insertSelective(CompetitivePrice record);
}