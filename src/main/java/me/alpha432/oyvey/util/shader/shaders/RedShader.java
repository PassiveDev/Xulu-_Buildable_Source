//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Jorge\Desktop\Minecraft-Deobfuscator3000-master\1.12 stable mappings"!

/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.ScaledResolution
 *  org.lwjgl.opengl.GL20
 */
package me.alpha432.oyvey.util.shader.shaders;

import me.alpha432.oyvey.util.shader.FramebufferShader;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.opengl.GL20;

public class RedShader
extends FramebufferShader {
    private static RedShader INSTANCE;
    protected float time = 0.0f;

    private RedShader() {
        super("red.frag");
    }

    public static RedShader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RedShader();
        }
        return INSTANCE;
    }

    @Override
    public void setupUniforms() {
        this.setupUniform("time");
        this.setupUniform("resolution");
        this.setupUniform("texelSize");
    }

    @Override
    public void updateUniforms() {
        GL20.glUniform1f((int)this.getUniform("time"), (float)this.time);
        GL20.glUniform2f((int)this.getUniform("resolution"), (float)new ScaledResolution(this.mc).getScaledWidth(), (float)new ScaledResolution(this.mc).getScaledHeight());
        GL20.glUniform2f((int)this.getUniform("texelSize"), (float)(1.0f / (float)this.mc.displayWidth * (this.radius * this.quality)), (float)(1.0f / (float)this.mc.displayHeight * (this.radius * this.quality)));
        if (!this.animation) {
            return;
        }
        this.time = this.time > 100.0f ? 0.0f : (float)((double)this.time + 0.05 * (double)this.animationSpeed);
    }
}

