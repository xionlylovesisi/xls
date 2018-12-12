package price;

import price.PlatformReferencePriceWarnHistory;

public interface PlatformReferencePriceWarnHistoryMapper {
    int insert(PlatformReferencePriceWarnHistory record);

    int insertSelective(PlatformReferencePriceWarnHistory record);
}