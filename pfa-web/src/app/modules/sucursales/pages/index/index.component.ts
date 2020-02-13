import { Component, OnInit } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { BandasService } from 'src/app/core/services/api/bandas.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Juez } from 'src/app/core/models/juez';
import { JuecesService } from 'src/app/core/services/api/jueces.service';
import { SucursalesService } from 'src/app/core/services/api/sucursales.service';
import { Sucursal } from 'src/app/core/models/sucursal';
import { SucursalesEditComponent } from '../edit/edit.component';

@Component({
    selector: 'bandas-index',
    templateUrl: 'index.component.html'
})

export class SucursalesIndexComponent implements OnInit {
    sucursales: Sucursal[];

    constructor(private sucursalesService: SucursalesService,
        private modalService: NgbModal) {
    }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        this.sucursales = await this.sucursalesService.getAll();
    }

    async edit(juez: Juez) {
        const modalRef = this.modalService.open(SucursalesEditComponent);

        if (juez) {
            modalRef.componentInstance.codigo = juez.codigo;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete(sucursal: Sucursal) {
        debugger;
        await this.sucursalesService.delete(sucursal.codigo);
        this.getAll();
    }
}