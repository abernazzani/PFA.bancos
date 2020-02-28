import { Component, OnInit, Input } from '@angular/core';

import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Vigilante } from 'src/app/core/models/vigilante';
import { VigilantesService } from 'src/app/core/services/api/vigilantes.service';

@Component({
    selector: 'vigilante-edit',
    templateUrl: 'edit.component.html'
})

export class VigilantesEditComponent implements OnInit {
    loading: boolean;



    @Input()
    codigo: string;

    protected vigilante: Vigilante;
    contraseña: string;

    constructor(private vigilanteService: VigilantesService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        this.activatedRoute.params.subscribe(async (params) => {
            this.codigo = this.codigo || params["id"];
            debugger;
            if (this.codigo) {
                this.vigilante = await this.vigilanteService.getPorCodigo(this.codigo);
            }
            else {
                this.vigilante = new Vigilante();
            }
        });

    }


    async save() {
        debugger;
        //console.log(this.codigo);
        if (this.codigo) {
            await this.vigilanteService.update(this.vigilante);
        } else {
            //await this.vigilanteService.create(this.vigilante, this.contraseña);
        }
        this.activeModal.close(ModalResult.Ok);
    }

    // async save() {
    //     await this.vigilanteService.create(this.vigilante);
    //  this.activeModal.close(ModalResult.Ok);
    // }

    cancel() {
        if (this.ngbModalService.hasOpenModals()) {
        this.activeModal.close(ModalResult.Cancel);
       } else {
             this.location.back();
       }
    }
}
