package com.study.bookcafe.borrow.interfaces.borrower;

import com.study.bookcafe.borrow.domain.borrower.Borrower;
import com.study.bookcafe.borrow.infrastructure.query.borrower.BorrowerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

// componentModel : 스프링 컨테이너에 빈으로 등록
// unmappedTargetPolicy : target이 매핑되지 않았을 때 정책
@Named("BorrowerMapper")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BorrowerMapper {

    // Borrower -> BorrowerEntity
    @Named("BorrowerToBorrowerEntity")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "borrowCount", source = "borrowCount")
    BorrowerEntity toBorrowerEntity(Borrower borrower);

    // BorrowerEntity -> Borrower
    @Named("BorrowerEntityToBorrower")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "level", source = "level")
    @Mapping(target = "borrowCount", source = "borrowCount")
    Borrower toBorrower(BorrowerEntity BorrowerEntity);
}
