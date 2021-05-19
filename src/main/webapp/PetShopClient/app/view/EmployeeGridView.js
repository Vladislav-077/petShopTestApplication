Ext.define('EmployeeCatalog.view.EmployeeGridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.employeeGridView',
    width: 400,
    height: 300,
    frame: true,
    store: 'EmployeeCatalogStore',
    iconCls: 'icon-user',
    viewConfig:{
        markDirty:false
    },
    columns: [
        {
            text: 'Имя сотрудника',
            flex: 1,
            sortable: true,
            dataIndex: 'name',
            editor: {
                xtype:'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }
        },
        {
            text: 'Фамилия сотрудника',
            flex: 1,
            sortable: true,
            dataIndex: 'lastName',
            editor: {
                xtype:'textfield',
                allowBlank: false,
                blankText: 'Это поле должно быть заполнено'
            }
        },
        {
          text: 'Возраст сотрудника',
          flex: 1,
          sortable: true,
          dataIndex: 'age',
          editor: {
            xtype:'textfield',
            allowBlank: false,
            blankText:'Это поле должно быть заполнено'
          }
        },
        {
          text: 'Должность сотрудника',
          flex: 1,
          sortable: true,
          dataIndex: 'positionName'
        }

    ],
    plugins: [
        Ext.create('Ext.grid.plugin.RowEditing', {
            clicksToEdit: 2,
            saveBtnText: 'Сохранить',
            cancelBtnText: 'Отменить'
        })
    ],
    selType: 'rowmodel',
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Добавить сотрудника',
                    action: 'create',
                    iconCls: 'pictos pictos-user'
                },
                '-',
                {
                    action: 'delete',
                    text: 'Удалить сотрудника',
                    iconCls: 'pictos pictos-trash',
                    disabled: true
                }
            ]
        }
    ]
});
