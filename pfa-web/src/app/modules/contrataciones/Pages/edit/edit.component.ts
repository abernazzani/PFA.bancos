import { Component, OnInit, Input } from '@angular/core';
import { ContratacionesService } from 'src/app/core/services/api/contrataciones.service';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Contratacion} from 'src/app/core/models/contratacion';

@Component({
    selector: 'contrataciones-edit',
    templateUrl: 'edit.component.html'
})

export class ContratacionesEditComponent implements OnInit {
    loading: boolean;


    @Input()
    codigo: string;

    protected contratacion: Contratacion;

    constructor(private contratacionesService: ContratacionesService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
       
        await this.activatedRoute.params.subscribe(async params => {
            this.codigo = this.codigo || params["id"];
            if (this.codigo) {
                this.contratacion = await this.contratacionesService.getPorCodigoSucursal(this.codigo);
                debugger;
            } else {
                this.contratacion = new Contratacion();
            }    
        });

    }

    async save() {
        debugger;
        if (this.codigo) {
            await this.contratacionesService.update(this.contratacion);
        } else {
            await this.contratacionesService.create(this.contratacion);
        }
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