package org.beigesoft.uml.service.edit;

import java.util.Set;

import org.beigesoft.service.ISrvI18n;
import org.beigesoft.ui.service.ISrvDialog;
import org.beigesoft.uml.app.model.SettingsGraphicUml;
import org.beigesoft.uml.pojo.ShapeUmlWithName;

public class SrvEditShapeWithName<SH extends ShapeUmlWithName, DLI> extends ASrvEditElementUml<SH, DLI> {

  public SrvEditShapeWithName(ISrvI18n srvI18n,
      ISrvDialog<DLI> srvDialog, SettingsGraphicUml settingsGraphic) {
    super(srvI18n, srvDialog, settingsGraphic);
  }

  @Override
  public void  validate(SH ge, Set<String> result) {
    super.validate(ge, result);
    if(ge.getItsName() == null || ge.getItsName().trim().length() < 1) {
      result.add(getSrvI18n().getMsg("complete_name"));
    }
  }

  @Override
  public boolean isEquals(SH o1, SH o2) {
    if(!super.isEquals(o1, o2)) {
      return false;
    }
    if(o1.getIsAdjustMinimumSize() != o2.getIsAdjustMinimumSize()) {
      return false;
    }
    if(o1.getItsName() == null ? o2.getItsName() != null 
        : !o1.getItsName().equals(o2.getItsName())) {
      return false;
    }
    return true;
  }

  @SuppressWarnings("unchecked")
  @Override
  public SH createClone(SH m) {
    return (SH) m.clone();//TODO re-do to IFactory
  }
}
