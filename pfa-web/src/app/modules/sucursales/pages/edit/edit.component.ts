import { Component, OnInit, Input } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Juez } from 'src/app/core/models/juez';
import { JuecesService } from 'src/app/core/services/api/jueces.service';
import { Sucursal } from 'src/app/core/models/sucursal';
import { SucursalesService } from 'src/app/core/services/api/sucursales.service';
import { EntidadBancariaService } from 'src/app/core/services/api/entidad-bancaria.service';
import { EntidadBancaria } from 'src/app/core/models/entidad-bancaria';

@Component({
    selector: 'bandas-edit',
    templateUrl: 'edit.component.html'
})

export class SucursalesEditComponent implements OnInit {
    loading: boolean;

    @Input()
    codigo: string = null;

    isNew: boolean;

    sucursal: Sucursal;

    entidadesBancarias: EntidadBancaria[];

    constructor(private sucursalesServices: SucursalesService,
        private entidadesBancariasService: EntidadBancariaService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        this.isNew = this.codigo != null;

        this.entidadesBancarias = await this.entidadesBancariasService.getAll();

        await this.activatedRoute.params.subscribe(async params => {
            this.codigo = this.codigo || params["id"];
            debugger;
            if (this.codigo) {
                this.sucursal = await this.sucursalesServices.getByCode(this.codigo);
            } else {
                this.sucursal = new Sucursal();
                this.sucursal.codigoEntidad = null;
                this.sucursal.nroEmpleados = 0;
            }
        });

    }

    async save() {
        await this.sucursalesServices.create(this.sucursal);
        this.activeModal.close(ModalResult.Ok);
    }

    cancel() {
        if (this.ngbModalService.hasOpenModals()) {
            this.activeModal.close(ModalResult.Cancel);
        } else {
            this.location.back();
        }
    }
}