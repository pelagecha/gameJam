package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont screen1Text;

	int loops = 0;
	int screen = 1;
	int mouseX;
	int mouseY;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

		// Images
		img = new Texture("badlogic.jpg");

		// Text
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Comic Sans MS 400.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

		parameter.size = 30;
		parameter.color = Color.WHITE;
		screen1Text = generator.generateFont(parameter);

		generator.dispose();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);

		mouseX = Gdx.input.getX();
		mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

		switch(screen) {
			case 1: screen1();
		}

		batch.begin();
		batch.draw(img, mouseX, mouseY);
		batch.end();
	}

	public void screen1() {
		String text = "centering text is fucken hard wtf";

		GlyphLayout layout = new GlyphLayout(screen1Text, text);

		batch.begin();
		screen1Text.draw(batch, text, (Gdx.graphics.getWidth() / 2) - (layout.width / 2), (Gdx.graphics.getHeight() / 2) + (layout.height / 2));
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		screen1Text.dispose();
	}
}
