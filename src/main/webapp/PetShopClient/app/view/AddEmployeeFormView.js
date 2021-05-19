Ext.define('EmployeeCatalog.view.AddEmployeeFormView', {
    extend: 'Ext.window.Window',
    xtype: 'basic-window',
    alias: 'widget.addEmployeeFormView',
    autoShow: true,
    title: 'Форма добавления сотрудника',
    bodyPadding: 5,
    resizable: true,
    height: 330,
    width: 380,
    frame: true,
    layout: 'fit',
    modal: true,

    items: [
        {
            bodyPadding: 10,
            xtype: 'form',
            items: [
                {
                    xtype: 'textfield',
                    labelWidth: 150,
                    name: 'name',
                    fieldLabel: 'Имя сотрудника',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'textfield',
                    labelWidth: 150,
                    name: 'lastName',
                    fieldLabel: 'Фамилия сотрудника',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'textfield',
                    labelWidth: 150,
                    name: 'age',
                    fieldLabel: 'Возраст сотрудника',
                    allowBlank: false,
                    blankText: 'Это поле должно быть заполнено'
                },
                {
                    xtype: 'container',
                    scrollable: false,
                    layout: 'anchor',
                    items: [{
                      xtype: 'combo',
                      llowBlank: false,
                      forceSelection: true,
                      store: {
                        type: 'array',
                        fields: [ 'positionName' ],
                        data: [
                          ['Разработчик'],
                          ['Дизайнер'],
                          ['Менеджер'],
                          ['Директор']
                        ]
                      },
                      onFocus: function() {
                        var me = this;
                        if (!me.isExpanded) {
                          me.expand()
                        }
                        me.getPicker().focus();
                      },
                      displayField: 'positionName',
                      valueField  : 'positionName',
                      value: 'Дизайнер',
                      fieldLabel: 'Должность сотрудника',
                      anchor: '0',
                      queryMode: 'local',
                      selectOnTab: false,
                      name: 'positionName',
                    }]
                  }
            ]
        }
    ],

    buttons: [
        {
            text: 'Сохранить',
            action: 'save',
            disabled: true
        },
        {
            text: 'Отменить',
            handler: function () {
                this.up('window').close();
            }

        }
    ]
});
