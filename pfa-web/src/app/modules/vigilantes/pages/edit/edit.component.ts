import { Component, OnInit, Input } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Location } from '@angular/common';
import { Vigilante } from 'src/app/core/models/vigilante';
import { VigilantesService } from 'src/app/core/services/api/vigilantes.service';

@Component({
    selector: 'bandas-edit',
    templateUrl: 'edit.component.html'
})

export class VigilantesEditComponent implements OnInit {
    loading: boolean;

    @Input()
    nombre: string;

    protected vigilante: Vigilante;

    constructor(private vigilanteService: VigilantesService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        await this.activatedRoute.params.subscribe(async params => {
            this.nombre = this.nombre || params["nombre"];
            //debugger;
            if (this.nombre) {
                this.vigilante = await this.vigilanteService.getPorNombre(this.nombre);
                
            } else {
                this.vigilante = new Vigilante();
            }
        });

    }

    async create() {
        await this.vigilanteService.create(this.vigilante);
        this.activeModal.close(ModalResult.Ok);
    }

    async update() {
        await this.vigilanteService.update(this.vigilante);
        this.activeModal.close(ModalResult.Ok);
    }

    async delete() {
        await this.vigilanteService.delete(this.vigilante.codigo);
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