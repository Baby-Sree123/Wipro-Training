import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAccont } from './create-accont';

describe('CreateAccont', () => {
  let component: CreateAccont;
  let fixture: ComponentFixture<CreateAccont>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateAccont]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateAccont);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
