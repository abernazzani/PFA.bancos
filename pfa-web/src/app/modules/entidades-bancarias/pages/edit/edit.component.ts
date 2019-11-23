import { Component, OnInit, Input } from '@angular/core';
import { EntidadBancaria } from 'src/app/core/models/entidad-bancaria';
import { EntidadBancariaService } from 'src/app/core/services/api/entidad-bancaria.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Location } from '@angular/common';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';

@Component({
    selector: 'entidades-bancarias-edit',
    templateUrl: 'edit.component.html'
})

export class EntidadesBancariasEditComponent implements OnInit {
    loading: boolean;

    @Input()
    codigo: string;

    protected entidadBancaria: EntidadBancaria;

    constructor(private entidadBancariaService: EntidadBancariaService,
        private location: Location,
        public activeModal: NgbActiveModal,
        private ngbModalService: NgbModal,
        private activatedRoute: ActivatedRoute) { }

    async ngOnInit() {
        await this.activatedRoute.params.subscribe(async params => {
            this.codigo = this.codigo || params["id"];
            if (this.codigo) {
                this.entidadBancaria = await this.entidadBancariaService.getByCode(this.codigo);
            } else {
                this.entidadBancaria = new EntidadBancaria();
            }
        });

    }

    async save() {
        debugger;
        if (this.codigo) {
            await this.entidadBancariaService.update(this.entidadBancaria);
        } else {
            await this.entidadBancariaService.create(this.entidadBancaria);
        }
        this.activeModal.close(ModalResult.Ok);
    }

    cancel() {
        if (this.ngbModalService.hasOpenModals()) {
            this.activeModal.close(ModalResult.Cancel);
        } else {
            this.location.back(); // <-- go back to previous location on cancel
        }
    }
}