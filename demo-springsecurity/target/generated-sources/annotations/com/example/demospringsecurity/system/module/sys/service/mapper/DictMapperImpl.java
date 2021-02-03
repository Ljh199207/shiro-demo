package com.example.demospringsecurity.system.module.sys.service.mapper;

import com.example.demospringsecurity.system.module.sys.entity.Dict;
import com.example.demospringsecurity.system.module.sys.entity.DictDetail;
import com.example.demospringsecurity.system.module.sys.service.dto.DictDTO;
import com.example.demospringsecurity.system.module.sys.service.dto.DictDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-23T09:28:56+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class DictMapperImpl implements DictMapper {

    @Override
    public Dict toEntity(DictDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Dict dict = new Dict();

        dict.setId( dto.getId() );
        dict.setName( dto.getName() );
        dict.setRemark( dto.getRemark() );
        dict.setCreateTime( dto.getCreateTime() );
        dict.setDictDetails( dictDetailDTOListToDictDetailList( dto.getDictDetails() ) );

        return dict;
    }

    @Override
    public DictDTO toDto(Dict entity) {
        if ( entity == null ) {
            return null;
        }

        DictDTO dictDTO = new DictDTO();

        dictDTO.setId( entity.getId() );
        dictDTO.setName( entity.getName() );
        dictDTO.setRemark( entity.getRemark() );
        dictDTO.setDictDetails( dictDetailListToDictDetailDTOList( entity.getDictDetails() ) );
        dictDTO.setCreateTime( entity.getCreateTime() );

        return dictDTO;
    }

    @Override
    public List<Dict> toEntity(List<DictDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Dict> list = new ArrayList<Dict>( dtoList.size() );
        for ( DictDTO dictDTO : dtoList ) {
            list.add( toEntity( dictDTO ) );
        }

        return list;
    }

    @Override
    public List<DictDTO> toDto(List<Dict> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DictDTO> list = new ArrayList<DictDTO>( entityList.size() );
        for ( Dict dict : entityList ) {
            list.add( toDto( dict ) );
        }

        return list;
    }

    protected DictDetail dictDetailDTOToDictDetail(DictDetailDTO dictDetailDTO) {
        if ( dictDetailDTO == null ) {
            return null;
        }

        DictDetail dictDetail = new DictDetail();

        dictDetail.setId( dictDetailDTO.getId() );
        dictDetail.setLabel( dictDetailDTO.getLabel() );
        dictDetail.setValue( dictDetailDTO.getValue() );
        dictDetail.setSort( dictDetailDTO.getSort() );
        dictDetail.setCreateTime( dictDetailDTO.getCreateTime() );

        return dictDetail;
    }

    protected List<DictDetail> dictDetailDTOListToDictDetailList(List<DictDetailDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<DictDetail> list1 = new ArrayList<DictDetail>( list.size() );
        for ( DictDetailDTO dictDetailDTO : list ) {
            list1.add( dictDetailDTOToDictDetail( dictDetailDTO ) );
        }

        return list1;
    }

    protected DictDetailDTO dictDetailToDictDetailDTO(DictDetail dictDetail) {
        if ( dictDetail == null ) {
            return null;
        }

        DictDetailDTO dictDetailDTO = new DictDetailDTO();

        dictDetailDTO.setId( dictDetail.getId() );
        dictDetailDTO.setLabel( dictDetail.getLabel() );
        dictDetailDTO.setValue( dictDetail.getValue() );
        dictDetailDTO.setSort( dictDetail.getSort() );
        dictDetailDTO.setCreateTime( dictDetail.getCreateTime() );

        return dictDetailDTO;
    }

    protected List<DictDetailDTO> dictDetailListToDictDetailDTOList(List<DictDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<DictDetailDTO> list1 = new ArrayList<DictDetailDTO>( list.size() );
        for ( DictDetail dictDetail : list ) {
            list1.add( dictDetailToDictDetailDTO( dictDetail ) );
        }

        return list1;
    }
}
